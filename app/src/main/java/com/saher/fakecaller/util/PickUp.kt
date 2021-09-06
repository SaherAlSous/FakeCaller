import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.runtime.MutableState
import com.saher.fakecaller.ui.MainActivity

class PickUp(): MainActivity(){

     val pick = registerForActivityResult(GetContent()){ uri ->

     }
}