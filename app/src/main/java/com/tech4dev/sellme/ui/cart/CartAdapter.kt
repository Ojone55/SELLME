package com.tech4dev.sellme.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tech4dev.sellme.R
import com.tech4dev.sellme.data.models.Product

class CartAdapter(val context: Context, val listOfSelectedProducts: List<Product>):RecyclerView.Adapter<CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
       val itemView=LayoutInflater.from(context).inflate(R.layout.layout_cart,parent,false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        var product : Product =listOfSelectedProducts[position]

        //show name
        holder.productName.text =product.name

        //show price
        Glide. with(context)
            .load(product.image)
            .into(holder.image)


    }

    override fun getItemCount(): Int = listOfSelectedProducts.size



}
class CartViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val image:ImageView=itemView.findViewById(R.id.image)
    val productName: TextView =itemView.findViewById(R.id.product_name)
    val  price:TextView=itemView.findViewById(R.id.price)
    val  quantity:TextView=itemView.findViewById(R.id.quantity)
    val  increasQty:TextView=itemView.findViewById(R.id.increase_quantity)
    val  decreaseQty:TextView=itemView.findViewById(R.id.decrease_quantity)
    val  delete:TextView=itemView.findViewById(R.id.delete)






}