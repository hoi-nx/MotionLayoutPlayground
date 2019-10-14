package com.piotrprus.motionlayoutplayground.fragments.start


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.piotrprus.motionlayoutplayground.R
import com.piotrprus.motionlayoutplayground.data.model.StartSceneItem
import com.piotrprus.motionlayoutplayground.databinding.FragmentStartBinding

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = StartListAdapter(navigateToScene)
        binding.startFragmentRV.adapter = adapter
        adapter.submitList(startSceneList)
    }

    private val navigateToScene: (Int) -> Unit = { destination ->
        findNavController().navigate(destination)
    }

private val startSceneList =
    listOf(StartSceneItem("Scene 1", R.id.sceneOneFragment, "Test dialog for first scene"))
}
