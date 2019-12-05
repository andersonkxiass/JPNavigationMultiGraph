package anderson.k.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserSessionViewModel : ViewModel() {

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED        // The user has authenticated successfull
    }

    val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun signOut(){
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun signIn() {
        authenticationState.value = AuthenticationState.AUTHENTICATED
    }
}