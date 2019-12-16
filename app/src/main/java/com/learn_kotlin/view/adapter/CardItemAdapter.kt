package com.learn_kotlin.view.adapter

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.learn_kotlin.R
import com.learn_kotlin.databinding.ItemFeedBinding
import com.learn_kotlin.model.Feed

class CardItemAdapter(
    feeds: List<Feed>,
    private val mActivity: FragmentActivity
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
        val feed: Feed = mFeedList.get(position)

        holder.apply {
            mItemBinding.lifecycleOwner = mActivity
            bind(feed)
            mItemBinding.imageLike.apply {
                setOnClickListener {
                    mFeedList.get(position).like = !mFeedList.get(position).like

                    val animator: ObjectAnimator =
                        ObjectAnimator.ofFloat(it, "translationY", -52f, 0f)
                    animator.apply {
                        duration = 500
                        interpolator = BounceInterpolator()
                        start()
                    }

                    holder.apply {
                        bind(mFeedList.get(position))
                    }
                }
            }
        }
    }

    inner class CardItemViewHolder(var mItemBinding: ItemFeedBinding) :
        RecyclerView.ViewHolder(mItemBinding.root) {

        fun bind(feedData: Feed) {
            mItemBinding.apply {
                feed = feedData
                executePendingBindings()
            }
        }
    }
}
