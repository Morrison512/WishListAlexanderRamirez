import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlistalexanderramirez.R
import com.example.wishlistalexanderramirez.WishList

class wListAdapter(private val context: Context,private val WishLists: List<WishList>): RecyclerView.Adapter<wListAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemNameTextView: TextView
        var itemPriceTextView: TextView
        var wLWebSiteTextView: TextView

        init {
            itemNameTextView = itemView.findViewById(R.id.itemNameTv)
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTv)
            wLWebSiteTextView = itemView.findViewById(R.id.itemWebsiteTv)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val wLView = inflater.inflate(R.layout.wish_item, parent, false)

        return ViewHolder(wLView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishList = WishLists[position]

        holder.itemNameTextView.text = wishList.itemName
        holder.itemPriceTextView.text = wishList.itemPrice
        holder.wLWebSiteTextView.text = wishList.itemWebSite
    }
    override fun getItemCount() = WishLists.size
}