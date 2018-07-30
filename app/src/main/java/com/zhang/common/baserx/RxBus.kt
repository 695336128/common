package com.zhang.common.baserx

import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.Observable


/**
 * Created by zhang .
 * DATA: 2018/7/30 .
 * Description : 用RxJava 实现 EventBus
 * 引入J神的rxrelay2,即使出现异常也不会终止订阅关系的 RxRelay
 */

/**
 * EventMsg eventMsg = new EventMsg();
 * eventMsg.setMsg("发送数据");
 * RxBus.getInstance().post(eventMsg);
 */
class RxBus private constructor() {

    private var mBus: Relay<Any>

    init {
        mBus = PublishRelay.create()
        mBus = mBus.toSerialized()
    }

    //    val subjectMapper: ConcurrentHashMap<in Any,MutableList<Relay<Any>>> = ConcurrentHashMap()
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RxBus()
        }
    }

    /**
     * 发送事件
     */
    fun post(content: Any) {
        mBus.accept(content)
    }

    fun <T> toObservable(tClass: Class<T>): Observable<T> {
        return mBus.ofType(tClass)
    }

    fun hasObservers(): Boolean {
        return mBus.hasObservers()
    }


//    /**
//     * 注册事件源
//     */
//    fun register(tag: Any): Observable<Any> {
//        var subjectList: MutableList<Relay<Any>>? = subjectMapper[tag]
//        if (null == subjectList) {
//            subjectList = ArrayList()
//            subjectMapper[tag] = subjectList
//        }
//        val subject: Relay<Any> = PublishRelay.create()
//        subject.toSerialized()
//        subjectList.add(subject)
//        return subject
//    }
//
//    /**
//     * 取消注册
//     */
//    fun unregister(tag: Any, observable: Observable<*>): RxBus {
//        val subjectList:MutableList<Relay<Any>>? = subjectMapper[tag]
//        if (null != subjectList){
//            subjectList.remove(observable)
//            if (isEmpty(subjectList)){
//                subjectMapper.remove(tag)
//            }
//        }
//        return instance
//    }
//
//    /**
//     * 触发事件
//     */
//    fun post(content: Any) {
//        post(content.javaClass.name, content)
//    }
//
//    /**
//     * 触发事件
//     */
//    fun post(tag: Any,content: Any){
//        val subjectList:MutableList<Relay<Any>>? = subjectMapper[tag]
//        if(!isEmpty(subjectList) && subjectList != null){
//            for (subject in subjectList){
//                subject.accept(content)
//            }
//        }
//
//    }
//
//    fun isEmpty(collection: Collection<Relay<*>>?): Boolean {
//        return null == collection || collection.isEmpty()
//    }


}