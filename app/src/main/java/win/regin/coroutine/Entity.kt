package win.regin.coroutine

/**
 * @author :Reginer in  2018/12/7 16:34.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
data class BaseEntity<T>(
        var errorCode: Int = 1,
        var errorMsg: String = "",
        var data: T
)

data class WeChatSubscriptionEntity(
        /**
         *
         * courseId : 13
         * id : 408
         * name : 鸿洋
         * order : 190000
         * parentChapterId : 407
         * userControlSetTop : false
         * visible : 1
         */

        var courseId: Int = 0,
        var id: Int = 0,
        var name: String? = null,
        var order: Int = 0,
        var parentChapterId: Int = 0,
        var isUserControlSetTop: Boolean = false,
        var visible: Int = 0
)

