package anderson.k.features

import anderson.k.R
import anderson.k.utils.setupWithNavController
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_host_fragment.*

class MainHostFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.main_host_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navGraphIds = listOf(R.navigation.main_graph, R.navigation.stub_graph)

        val currentNavController = bottom_main.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.main_host,
            intent = Intent()
        )

        currentNavController.observe(this, Observer { navController ->

            navController?.apply {

                addOnDestinationChangedListener { _, destination, _ ->
                    when (destination.id) {
                        R.id.detail -> {
                            bottom_main.animate().translationY(bottom_main.height.toFloat())
                            bottom_main.visibility = View.GONE
                        }
                        else -> {
                            bottom_main.animate().translationY(0f)
                            bottom_main.visibility = View.VISIBLE
                        }
                    }
                }
            }
        })
    }
}
