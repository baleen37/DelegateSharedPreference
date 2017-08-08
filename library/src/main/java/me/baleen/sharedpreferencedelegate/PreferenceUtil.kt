package me.baleen.sharedpreferencedelegate

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import kotlin.reflect.KProperty

/**
 * Created by baleen37 on 08/08/2017.
 */

abstract class PreferenceUtil {
    companion object {
        var context: Context? = null

        /**
         * Dont place Activity context eg. Fragment's context, Activity's context
         *
         * please placing ApplicationContext
         * */
        fun init(context: Context) {
            this.context = context
        }

        val sharedPreference: SharedPreferences by lazy {
            context ?: throw IllegalArgumentException("context is null")
            PreferenceManager.getDefaultSharedPreferences(context)
        }
    }

    abstract class PreferenceDelegate<T>(var key: String? = null, val defaultValue: T?) {
        abstract operator fun getValue(ref: Any?, property: KProperty<*>): T
        abstract operator fun setValue(ref: Any?, property: KProperty<*>, value: T)
    }

    class IntPref(key: String? = null, defaultValue: Int? = null) : PreferenceDelegate<Int>(key, defaultValue) {

        override fun getValue(ref: Any?, property: KProperty<*>): Int {
            return sharedPreference.getInt(key ?: property.name, defaultValue ?: 0)
        }

        override fun setValue(ref: Any?, property: KProperty<*>, value: Int) {
            sharedPreference.edit().putInt(key ?: property.name, value).apply()
        }
    }

    class LongPref(key: String? = null, defaultValue: Long? = null) : PreferenceDelegate<Long>(key, defaultValue) {

        override fun getValue(ref: Any?, property: KProperty<*>): Long {
            return sharedPreference.getLong(key ?: property.name, defaultValue ?: 0)
        }

        override fun setValue(ref: Any?, property: KProperty<*>, value: Long) {
            sharedPreference.edit().putLong(key ?: property.name, value).apply()
        }
    }

    class BooleanPref(key: String? = null, defaultValue: Boolean? = null) : PreferenceDelegate<Boolean>(key, defaultValue) {

        override fun getValue(ref: Any?, property: KProperty<*>): Boolean {
            return sharedPreference.getBoolean(key ?: property.name, defaultValue ?: false)
        }

        override fun setValue(ref: Any?, property: KProperty<*>, value: Boolean) {
            sharedPreference.edit().putBoolean(key ?: property.name, value).apply()
        }
    }

    class FloatPref(key: String? = null, defaultValue: Float? = null) : PreferenceDelegate<Float>(key, defaultValue) {

        override fun getValue(ref: Any?, property: KProperty<*>): Float {
            return sharedPreference.getFloat(key ?: property.name, defaultValue ?: 0.0f)
        }

        override fun setValue(ref: Any?, property: KProperty<*>, value: Float) {
            sharedPreference.edit().putFloat(key ?: property.name, value).apply()
        }
    }

    class StringPref(key: String? = null, defaultValue: String? = null) : PreferenceDelegate<String>(key, defaultValue) {

        override fun getValue(ref: Any?, property: KProperty<*>): String {
            return sharedPreference.getString(key ?: property.name, defaultValue ?: "")
        }

        override fun setValue(ref: Any?, property: KProperty<*>, value: String) {
            sharedPreference.edit().putString(key ?: property.name, value).apply()
        }
    }
}
