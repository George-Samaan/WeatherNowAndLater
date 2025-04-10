
import app.cash.turbine.test
import com.vodafonetask.cityinput.domain.usecase.lastcity.GetLastCityUseCase
import com.vodafonetask.cityinput.domain.usecase.savecity.SaveCityUseCase
import com.vodafonetask.cityinput.presentation.viewmodel.CityInputViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class CityInputViewModelTest {

    private val saveCityUseCase = mock<SaveCityUseCase>()
    private val getLastCityUseCase = mock<GetLastCityUseCase>()
    private lateinit var viewModel: CityInputViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        whenever(getLastCityUseCase()).thenReturn(null)
        viewModel = CityInputViewModel(saveCityUseCase, getLastCityUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `onCityChanged updates cityName`() = runTest {
        val testCity = "Cairo"
        viewModel.onCityChanged(testCity)

        viewModel.cityName.test {
            assert(awaitItem() == testCity)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onSearchClicked returns trimmed city name`() {
        viewModel.onCityChanged("  Cairo  ")
        val result = viewModel.onSearchClicked()
        assert(result == "Cairo")
    }
}