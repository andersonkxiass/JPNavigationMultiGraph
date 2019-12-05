package anderson.k.features.main

import anderson.k.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detail.setOnClickListener {
            it.findNavController().navigate(MainFragmentDirections.goToDetail())
        }
    }
}