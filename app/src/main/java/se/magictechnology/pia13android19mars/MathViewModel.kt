package se.magictechnology.pia13android19mars

import androidx.lifecycle.ViewModel

/**
 * Very nice viewmodel.
 * Use [checkpersonnummer] to check a personnummer
*/
class MathViewModel : ViewModel() {

    /**
     * Simple double number function
     *
     * @param innumber The number to multiply
     * @return The result as a number
     */
    fun dummymath(innumber : Int) : Int {

        var result = innumber * 2
        if(result > 100) {
            result = 100
        }

        return result
    }

    /**
     * # Check a personnummer
     * Check a **personnummer**
     *
     * @param persnr The **personnummer** to check
     * @return The year of birth or null if invalid
     */
    fun checkpersonnummer(persnr : String) : Int? {

        // ÅÅMMDD-XXXX

        if(persnr.length != 11) {
            return null
        }

        if(persnr[6] != '-') {
            return null
        }

        if(persnr.replace("-", "").toLongOrNull() == null) {
            return null
        }
        
        // ÅÅMMDDXXX
        var checknr = persnr.replace("-", "").substring(0, 9)

        var sum = 0

        // 7 % 2 .... 3 * 2 = 6.... 7-6 = 1
        // 8 % 2 .... 4 * 2 = 8.... 8-8 = 0

        checknr.forEachIndexed { index, nr ->
            var addsum = 0
            if(index % 2 == 0) {
                addsum += nr.digitToInt() * 2
            } else {
                addsum += nr.digitToInt() * 1
            }

            if(addsum > 9) {
                // 7 * 2 = 14 .... 1..... 4
                sum += 1
                sum += addsum - 10
            } else {
                sum += addsum
            }
        }

        var kontrollsiffra = (10 - (sum % 10)) % 10

        if(kontrollsiffra != persnr.last().digitToInt()) {
            return null
        }

        return 20

    }


}