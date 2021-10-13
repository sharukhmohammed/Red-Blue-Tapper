package com.namshi.sharukh2

import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namshi.sharukh2.databinding.ItemBlockBinding

class TapAdapter(private val screenSize: Size) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Block>()
    private val tappedItems: ArrayDeque<Block> = ArrayDeque()

    init {
        for (i in 0 until 16) {
            items.add(Block(i, false))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ItemBlockBinding
            .bind(holder.itemView)
            .apply {

                root.layoutParams.apply {
                    height = screenSize.height / 4
                }

                val data = items[holder.adapterPosition]
                if (tappedItems.contains(data))
                    blockBg.setBackgroundColor(color(R.color.block_red))
                else
                    blockBg.setBackgroundColor(color(R.color.block_blue))

                root.setOnClickListener {
                    val tappedItem = items[holder.adapterPosition]
                    Log.w("QUEUE", " Before => $tappedItems")
                    if (tappedItems.size >= REMEMBER_LIMIT) {
                        tappedItems.removeFirstOrNull()?.let {
                            notifyItemChanged(it.id)
                        }
                    }
                    tappedItems.add(tappedItem)
                    notifyItemChanged(holder.adapterPosition)
                    Log.w("QUEUE", " After => $tappedItems")
                }
            }
    }

    override fun getItemCount(): Int = items.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        private const val REMEMBER_LIMIT = 2
    }

}