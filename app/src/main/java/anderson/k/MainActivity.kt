package anderson.k

import anderson.k.features.LoginHostFragment
import anderson.k.features.MainHostFragment
import anderson.k.features.UserSessionViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: UserSessionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.authenticationState.observe(this, Observer { authenticationState ->
                when (authenticationState) {
                    UserSessionViewModel.AuthenticationState.AUTHENTICATED -> {
                        logged()
                    }
                    UserSessionViewModel.AuthenticationState.UNAUTHENTICATED -> {
                        login()
                    }
                    else -> {}
                }
            })
    }

    fun logged() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.host, MainHostFragment(), "main")
            .commitNow()
    }

    fun login() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.host, LoginHostFragment(), "login")
            .commitNow()
    }
}
