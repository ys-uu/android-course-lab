package cn.edu.sicnu.cs.ys.exp_2

class ProgramAdviserModel {
    fun getLanguageInfo(langName: String): Int {
        return when(langName){
            "kotlin" -> R.string.tips_kotlin
            "java" -> R.string.tips_java
            "C++" -> R.string.tips_cpp
            else -> R.string.lang_kotlin
        }
    }
}
