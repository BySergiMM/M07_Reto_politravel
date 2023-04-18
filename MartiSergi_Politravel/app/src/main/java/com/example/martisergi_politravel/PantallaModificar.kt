import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.martisergi_politravel.ClasePaquetes
import com.example.martisergi_politravel.R
import com.google.gson.Gson
import java.io.File

class PantallaModificar : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var paisEditText: EditText
    private lateinit var lugaresInteresantesEditText: EditText
    private lateinit var precioEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var duracionEditText: EditText
    private lateinit var gridView: GridView
    private lateinit var puntuacionRatingBar: RatingBar
    private lateinit var transporte: Spinner
    private var inicioTourCoordenadasX: Double = 0.0
    private var inicioTourCoordenadasY: Double = 0.0
    private var finTourCoordenadasX: Double = 0.0
    private var finTourCoordenadasY: Double = 0.0
    private lateinit var paquete: ClasePaquetes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dar_de_alta)

        // Inicialización de los componentes de la interfaz
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("avión", "barco", "coche"))
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        transporte = findViewById(R.id.transporte)
        transporte.adapter = adapterSpinner
        nombreEditText = findViewById(R.id.nombre)
        paisEditText = findViewById(R.id.pais)
        lugaresInteresantesEditText = findViewById(R.id.lugaresInteresantes)
        precioEditText = findViewById(R.id.precio)
        descripcionEditText = findViewById(R.id.descripcion)
        duracionEditText = findViewById(R.id.duracion)
        gridView = findViewById(R.id.gridview)
        puntuacionRatingBar = findViewById(R.id.puntuacion)
        // Cargar los datos del paquete seleccionado
        val position = intent.getIntExtra("position", -1)
        val gson = Gson()
        val file = File(filesDir, "infoViajes.json")
        val paquetes = if (file.exists()) {
            gson.fromJson(file.readText(), Array<ClasePaquetes>::class.java).toMutableList()
        } else {
            mutableListOf()
        }
        if (position >= 0 && position < paquetes.size) {
            paquete = paquetes[position]
            nombreEditText.setText(paquete.nombre)
            paisEditText.setText(paquete.pais)
            lugaresInteresantesEditText.setText(paquete.lugaresInteresantes)
            precioEditText.setText(paquete.precio.toString())
            descripcionEditText.setText(paquete.descripcion)
            duracionEditText.setText(paquete.duracion)
            transporte.setSelection(adapterSpinner.getPosition(paquete.transporte))
            puntuacionRatingBar.rating = paquete.puntuacion.toFloat()
            inicioTourCoordenadasX = paquete.inicioTourCoordenadas[0]
            inicioTourCoordenadasY = paquete.inicioTourCoordenadas[1]
            finTourCoordenadasX = paquete.finTourCoordenadas[0]
            finTourCoordenadasY = paquete.finTourCoordenadas[1]
        } else {
            Toast.makeText(this, "Error al cargar el paquete", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
