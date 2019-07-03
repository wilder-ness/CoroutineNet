package win.regin.coroutine.net

sealed class ViewState<out T> {
    companion object {
        fun <T> result(data: T?): ViewState<T> = Success(data)
        fun <T> loading(): ViewState<T> = Loading
        fun <T> error(error: String): ViewState<T> = Error(error)
        fun <T> empty(): ViewState<T> = Empty
        fun <T> tokenError(): ViewState<T> = TokenError
        fun <T> netError(error: String): ViewState<T> = NetError(error)
        fun <T> verError(error: String?): ViewState<T> = VerError(error)
    }

    object Loading : ViewState<Nothing>()
    data class Success<out T>(val results: T?) : ViewState<T>()
    data class Error(val error: String) : ViewState<Nothing>()
    data class NetError(val error: String) : ViewState<Nothing>()
    data class VerError(val error: String?) : ViewState<Nothing>()
    object Empty : ViewState<Nothing>()
    object TokenError : ViewState<Nothing>()
}