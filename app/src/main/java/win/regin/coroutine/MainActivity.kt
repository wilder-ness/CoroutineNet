package win.regin.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import win.regin.coroutine.net.ViewState

class MainActivity : AppCompatActivity() {

    private val mViewModel = MainModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            mViewModel.getWxSubscription()
        }

        mViewModel.mWxSubscription.observe(this, Observer {viewState->
            when(viewState ){
                is ViewState.Success->{
                    textView.text =viewState.results?.data.toString()
                }
            }

        })
    }
}
