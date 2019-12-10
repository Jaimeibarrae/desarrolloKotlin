package edu.utng.mx.introducciondesarrolloenandroid.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import edu.utng.mx.introducciondesarrolloenandroid.R
import kotlinx.android.synthetic.main.item_producto.view.*

//Muestra la informacion en el listview
class ProductosAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)//Almacena los datos

        val producto = listaProductos[position] //Toma la posicion de la lista

        layout.nombre.text = producto.titulo //Asigna el titulo
        layout.imageView.setImageResource(producto.imaTema//asigna la imagen
        )

        return layout
    }

}