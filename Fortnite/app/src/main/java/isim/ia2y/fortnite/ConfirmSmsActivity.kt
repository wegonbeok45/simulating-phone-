package isim.ia2y.fortnite

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import isim.ia2y.fortnite.databinding.ActivityConfirmSmsBinding

class ConfirmSmsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmSmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val phoneNumber = intent.getStringExtra("phone_number")
        val message = intent.getStringExtra("message")

        binding.editTextPhone.setText(phoneNumber)
        binding.editTextMessage.setText(message)

        binding.buttonSend.setOnClickListener {
            val editedPhoneNumber = binding.editTextPhone.text.toString()
            val editedMessage = binding.editTextMessage.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$editedPhoneNumber"))
            intent.putExtra("sms_body", editedMessage)
            startActivity(intent)
        }

        binding.buttonCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}