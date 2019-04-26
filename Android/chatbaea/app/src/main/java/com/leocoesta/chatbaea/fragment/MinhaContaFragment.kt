package com.leocoesta.chatbaea.fragment


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.auth.AuthUI
import com.leocoesta.chatbaea.R
import com.leocoesta.chatbaea.SignInActivity
import com.leocoesta.chatbaea.util.FirestoreUtil
import com.leocoesta.chatbaea.util.StorageUtil
import kotlinx.android.synthetic.main.fragment_minha_conta.*
import kotlinx.android.synthetic.main.fragment_minha_conta.view.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.newTask
import org.jetbrains.anko.support.v4.intentFor
import java.io.ByteArrayOutputStream

class MinhaContaFragment : Fragment() {

    private val RC_SELECT_IMAGE = 2
    private lateinit var selectedImageBytes: ByteArray
    private var pictureJustChanged = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_minha_conta, container, false)

        view.apply {
            imageView_profile_picture.setOnClickListener{
                val intent = Intent().apply {
                    type = "image/*"
                    action = Intent.ACTION_GET_CONTENT
                    putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
                }
                startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), RC_SELECT_IMAGE)
            }

            btn_save.setOnClickListener {
                if (::selectedImageBytes.isInitialized)
                    StorageUtil.uploadProfilePhoto(selectedImageBytes) { imagePath ->
                        FirestoreUtil.updateCurrentUser(
                            editText_name.text.toString(),
                            editText_bio.text.toString(),
                            imagePath
                        )
                    }
                else
                    FirestoreUtil.updateCurrentUser(
                        editText_name.text.toString(),
                        editText_bio.text.toString(),
                        null
                    )
            }

            btn_sign_out.setOnClickListener {
                AuthUI.getInstance()
                    .signOut(this@MinhaContaFragment.context!!)
                    .addOnCompleteListener {
                        startActivity(intentFor<SignInActivity>().newTask().clearTask())
                    }
            }
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null){
            val selectedImagePath = data.data
            val selectedImgBmp = MediaStore.Images.Media.getBitmap(activity?.contentResolver, selectedImagePath)

            val outputStream = ByteArrayOutputStream()
            selectedImgBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            selectedImageBytes = outputStream.toByteArray()

            // TODO: Load Picture

            pictureJustChanged = true
        }

    }

    override fun onStart() {
        super.onStart()
        FirestoreUtil.getCurrentUser { user ->
            if (this@MinhaContaFragment.isVisible) {
                editText_name.setText(user.name)
                editText_bio.setText(user.bio)
//                if (!pictureJustChanged && user.profilePicturePatch != null)
//                    GlideApp.with(this)
//                        .load(StorageUtil.pathToReference(user.profilePicturePatch))
//                        .placeHolder()
            }
        }
    }


}
