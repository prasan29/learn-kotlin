package com.learn_kotlin.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.learn_kotlin.base.BaseViewModel
import com.learn_kotlin.model.Feed
import com.learn_kotlin.view.adapter.CardItemAdapter

class MainViewModel : BaseViewModel() {
    private lateinit var mActivity: FragmentActivity
    private lateinit var mLifecycleOwner: LifecycleOwner

    fun setComponents(
        activity: FragmentActivity,
        callback: (adapter: CardItemAdapter) -> Unit
    ) {
        mActivity = activity
        mLifecycleOwner = activity

        val list = mutableListOf<Feed>()

        list.apply {
            add(0, Feed(false, null, 2, 2, true, listOf()))
            add(1, Feed(false, null, 2, 2, true, listOf()))
            add(2, Feed(false, null, 2, 2, true, listOf()))
            add(3, Feed(false, null, 2, 2, true, listOf()))
            add(4, Feed(false, null, 2, 2, true, listOf()))
            add(5, Feed(false, null, 2, 2, true, listOf()))
            add(6, Feed(false, null, 2, 2, true, listOf()))
        }

        callback(
            CardItemAdapter(
                list,
                activity
            )
        )

/*        CoroutineScope(Dispatchers.Main + Job()).launch {
            val user = fetchUser()
//            updateUser(user)
        }
    }

    private suspend fun fetchUser1(): String = withContext(Dispatchers.IO) {
        ""
    }

    *//*   withContext(Dispatchers.IO) {
       for (i in 0..10) {
           print(i)
       }
   }*//*


    private suspend fun fetchUser(): String = withContext(Dispatchers.IO) {
        ""
    }*/
    }
}