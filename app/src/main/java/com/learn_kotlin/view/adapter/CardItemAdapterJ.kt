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
import java.util.*

class CardItemAdapterJ(feeds: List<Feed>, private val mContext: Context) :
    RecyclerView.Adapter<CardItemAdapterJ.CardItemViewHolder>() {
    private val mFeedList: List<Feed>

    init {
        mFeedList = ArrayList(feeds)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemFeedBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_feed, parent, false
        )

        return CardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        val cardViewModel = CardViewModel()
        holder.bind(cardViewModel)
    }

    override fun getItemCount(): Int {
        return mFeedList.size
    }

    inner class CardItemViewHolder(var mBinding: ItemFeedBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(cardViewModel: CardViewModel) {
            mBinding.itemViewModel = cardViewModel
            mBinding.executePendingBindings()
        }
    }
}
