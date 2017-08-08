package me.baleen.sharedpreferencedelegate

/**
 * Created by baleen37 on 09/08/2017.
 */
class UserPreference : PreferenceUtil() {
    var email by StringPref("unknown")
    var age by IntPref("PREF_AGE")
    var male by BooleanPref(defaultValue = false)
    var score by FloatPref()
    var money by LongPref(key = "PREF_MONEY", defaultValue = 1000)
}