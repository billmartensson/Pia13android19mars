package se.magictechnology.pia13android19mars

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {

        var mathvm = MathViewModel()

        assertEquals(6, mathvm.dummymath(3))
        assertEquals(0, mathvm.dummymath(0))
        assertEquals(100, mathvm.dummymath(70))

    }

    @Test
    fun testcheckpersonnummer() {
        var mathvm = MathViewModel()

        assertEquals(null, mathvm.checkpersonnummer(""))
        assertEquals(null, mathvm.checkpersonnummer("xxxxxxxxxxxxxxxx"))

        assertEquals(null, mathvm.checkpersonnummer("121212X1212"))

        assertEquals(20, mathvm.checkpersonnummer("121212-1212"))
        assertEquals(20, mathvm.checkpersonnummer("200312-6642"))
        assertEquals(20, mathvm.checkpersonnummer("920316-6948"))
        assertEquals(20, mathvm.checkpersonnummer("261214-3079"))
        assertEquals(20, mathvm.checkpersonnummer("300220-1717"))
        assertEquals(null, mathvm.checkpersonnummer("30022X-1717"))


    }

}