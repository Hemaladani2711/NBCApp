import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hemaladani.nbcapp.data.local.LocalData
import com.hemaladani.nbcapp.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Objects

@RunWith(AndroidJUnit4::class)
class HomeRepositoryImplTest {
    val fakeFileName = "fakeTests.json"
    lateinit var context: Context
    lateinit var localData: LocalData

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        localData = LocalData(context)
    }


    @Test
    fun fetchHomeShelves_whenDataIsReadSuccessfully() {
        val shelves = localData.getHomePageShelves(Constants.fileName)
        assertEquals(true, Objects.nonNull(shelves.data))
        assertEquals(true,shelves.errorMessage.isNullOrEmpty())
    }
    @Test
    fun fetchHomeShelves_whenDatafailedToRetrieve() {
        val shelves = localData.getHomePageShelves(fakeFileName)
        assertEquals(true, Objects.isNull(shelves.data))
        assertEquals(true, shelves.errorMessage!!.isNotEmpty())
    }
}