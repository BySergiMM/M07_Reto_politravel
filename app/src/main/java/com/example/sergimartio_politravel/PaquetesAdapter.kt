
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sergimartio_politravel.ClaseDestinos
import com.example.sergimartio_politravel.R


class PaquetesAdapter(paquetes: List<ClaseDestinos>) :
    RecyclerView.Adapter<PaquetesAdapter.PaqueteViewHolder>() {
    private val paquetes: List<ClaseDestinos>

    init {
        this.paquetes = paquetes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaqueteViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return PaqueteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PaqueteViewHolder, position: Int) {
        val paquete: ClaseDestinos = paquetes[position]
        holder.nombrePaquete.setText(paquete.nombre)

    }

    override fun getItemCount(): Int {
        return paquetes.size
    }

    class PaqueteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nombrePaquete: TextView


        init {

            nombrePaquete = view.findViewById(R.id.text)

        }
    }
}