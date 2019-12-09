package com.learn_kotlin.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn_kotlin.R
import com.learn_kotlin.databinding.ItemFeedBinding
import com.learn_kotlin.model.Feed
import com.learn_kotlin.viewmodel.CardViewModel

class CardItemAdapter(feeds: List<Feed>, private val mContext: Context) :
    RecyclerView.Adapter<CardItemAdapter.CardItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val itemBinding = DataBindingUtil.inflate<ItemFeedBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_feed,
            parent,
            false
        )

        return CardItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return mFeedList.size
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        val viewModel = CardViewModel()
        holder.bind(viewModel)
    }

    private val mFeedList: List<Feed>

    init {
        mFeedList = ArrayList(feeds)
    }

    inner class CardItemViewHolder(var mItemBinding: ItemFeedBinding) :
        RecyclerView.ViewHolder(mItemBinding.root) {

        fun bind(viewModel: CardViewModel) {
            mItemBinding.itemViewModel = viewModel
            mItemBinding.executePendingBindings()
        }
    }
}
