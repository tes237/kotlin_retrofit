package com.ai.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LambdaActivity : AppCompatActivity() {

    lateinit var onEventListener: EventListener
    lateinit var onDistanceListener: DistanceListener
    lateinit var onSingleListener: SingleListener

    interface EventListener{
        fun onOk(arg1 : String, arg2 : Boolean)
    }

    interface DistanceListener{
        fun onDistance(arg1 : String, arg2 : Int)
    }

    interface SingleListener{
        fun onFinished(arg1 : Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bts1)

        setOnEventListener(object : EventListener
        {
            override fun onOk(arg1 : String, arg2 : Boolean)
            {
                Log.d("tag", "EventListener index=[$arg1], value=[$arg2]")
            }
        },
        object : DistanceListener
        {
            override fun onDistance(arg1: String, arg2: Int)
            {
                Log.d("tag", "DistanceListener index=[$arg1], value=[$arg2]")
            }
        })

        val arg1 = "aaa"
        val arg2 : Boolean = false

        setOnSingleListener { arg1 ->
            Log.d("tag", "single index=[$arg1]")
            Log.d("tag", "single index=[$arg1]")
        }

        onEventListener.onOk("aaa", true);
        onDistanceListener.onDistance("bbb", 100);


        onSingleListener.onFinished(333);
    }

    //람다 없이 쓰는 리스터 셋팅 함수
    fun setOnEventListener( listener1 : EventListener, listener2 : DistanceListener)
    {
        onEventListener = listener1
        onDistanceListener = listener2
    }

    //람다 사용한 하나의 인자 셋팅 함수
    fun setOnSingleListener( listener1 : (Int) -> Unit)
    {
        onSingleListener = object : SingleListener {
            override fun onFinished(arg1: Int) {
                listener1(arg1)
            }
        }
    }
}
