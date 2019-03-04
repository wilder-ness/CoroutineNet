package win.regin.coroutine.net

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import win.regin.coroutine.BaseEntity
import win.regin.coroutine.WeChatSubscriptionEntity


/**
 * @author :Reginer in  2018/1/16 16:37.
 * 联系方式:QQ:282921012
 * 功能描述:网络请求实现类
 */
interface NetApiService {

    @GET(Urls.WX_ARTICLE)
    fun getWeChatSubscription(): Deferred<BaseEntity<List<WeChatSubscriptionEntity>>>
}
