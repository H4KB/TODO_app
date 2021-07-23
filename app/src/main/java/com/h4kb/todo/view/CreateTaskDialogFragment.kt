package com.h4kb.todo.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.h4kb.todo.R
import com.h4kb.todo.databinding.DialogCreateTaskBinding
import java.util.jar.Attributes

class CreateTaskDialogFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DialogCreateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
}