package com.hemaladani.nbcapp.data

sealed class Resource<T>(val data: T? = null,
                         val errorMessage: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class DataError<T>(errorMessage: String) : Resource<T>(null, errorMessage)
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is DataError -> "Error[exception=$errorMessage]"
            is Loading<T> -> "Loading"
        }
    }

}