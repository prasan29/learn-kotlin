package com.learn_kotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.learn_kotlin.R
import com.learn_kotlin.databinding.ItemFeedBinding
import com.learn_kotlin.model.Feed
import com.learn_kotlin.viewmodel.CardViewModel

class CardItemAdapter(
    feeds: List<Feed>,
    private val mActivity: FragmentActivity,
    private val viewModel: CardViewModel
) :
    RecyclerView.Adapter<CardItemAdapter.CardItemViewHolder>() {

    private val mFeedList: List<Feed>

    init {
        mFeedList = ArrayList(feeds)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val itemBinding = DataBindingUtil.inflate<ItemFeedBinding>(
            LayoutInflater.from(mActivity),
            R.layout.item_feed, parent, false
        )

        return CardItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return mFeedList.size
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
//        val viewModel: CardViewModel =
//            ViewModelProviders.of(mActivity).get(CardViewModel::class.java)

        /*val viewModel: CardViewModel by lazy {
            ViewModelProviders.of(mActivity).get(CardViewModel::class.java)
        }*/

        holder.mItemBinding.lifecycleOwner = mActivity
        holder.bind(viewModel)

/*        holder.apply {
            mItemBinding.apply {
                lifecycleOwner = mActivity
            }
            bind(viewModel)
        }*/
    }

    inner class CardItemViewHolder(var mItemBinding: ItemFeedBinding) :
        RecyclerView.ViewHolder(mItemBinding.root) {

        fun bind(viewModel: CardViewModel) {
            mItemBinding.itemViewModel = viewModel
            mItemBinding.executePendingBindings()

/*            mItemBinding.apply {
                itemViewModel = viewModel
                executePendingBindings()
            }*/
        }
    }
}
