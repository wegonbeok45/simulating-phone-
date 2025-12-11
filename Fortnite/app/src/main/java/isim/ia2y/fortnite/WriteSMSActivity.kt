package isim.ia2y.fortnite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import isim.ia2y.fortnite.databinding.ActivityWriteSmsBinding

class WriteSmsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriteSmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConfirm.setOnClickListener {
            val phoneNumber = binding.editTextPhone.text.toString()
            val message = binding.editTextMessage.text.toString()

            val intent = Intent(this, ConfirmSmsActivity::class.java)
            intent.putExtra("phone_number", phoneNumber)
            intent.putExtra("message", message)
            startActivity(intent)
        }
    }
}