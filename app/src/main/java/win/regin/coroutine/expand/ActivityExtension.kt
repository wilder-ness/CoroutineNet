package win.regin.coroutine.expand

import android.app.Activity
import androidx.fragment.app.Fragment
import win.regin.coroutine.net.ViewState


/**
 * 通用返回值处理
 * 扩展到baseActivity 或者类似的基础类中
 * 可以调用其中的一些通用loading或者什么的-也可以直接在传入的方法中处理(onSuccess onLoading  onError)
 */
fun <T> Activity.onResult(
        result: ViewState<T>,
        onSuccess: (T?) -> Unit,
        onLoading: () -> Unit,
        onError: (String) -> Unit) {
    when (result) {
        is ViewState.Success -> {
//            hideLoading()
            onSuccess(result.results)
        }
        is ViewState.Loading -> {
            onLoading()
        }
        is ViewState.Error -> {
//            hideLoading()
            onError(result.error)
        }
        is ViewState.NetError -> {

        }
        is ViewState.TokenError -> {//退出
        }
    }
}

/**
 * 通用返回值处理
 * 扩展到baseFragment 或者类似的基础类中
 * 可以调用其中的一些通用loading或者什么的-也可以直接在传入的方法中处理(onSuccess onLoading  onError)
 */
fun <T> Fragment.onResult(
        result: ViewState<T>,
        onSuccess: (T?) -> Unit,
        onLoading: () -> Unit,
        onError: (String) -> Unit) {
    when (result) {
        is ViewState.Success -> {
//            hideLoading()
            onSuccess(result.results)
        }
        is ViewState.Loading -> {
            onLoading()
        }
        is ViewState.Error -> {
//            hideLoading()
            onError(result.error)
        }
        is ViewState.NetError -> {
//            hideLoading()
        }
        is ViewState.TokenError -> {//退出
//            hideLoading()
//            logout()
        }
    }
}