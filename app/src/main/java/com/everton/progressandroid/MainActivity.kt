package com.everton.progressandroid

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


open class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btClick(view: View) {
        val buttonSelect = view as Button
        var squareID = 0
        when (buttonSelect.id) {
            R.id.button -> squareID = 1
            R.id.button2 -> squareID = 2
            R.id.button3 -> squareID = 3
            R.id.button4 -> squareID = 4
            R.id.button5 -> squareID = 5
            R.id.button6 -> squareID = 6
            R.id.button7 -> squareID = 7
            R.id.button8 -> squareID = 8
            R.id.button9 -> squareID = 9
        }

        gamePlay(squareID, buttonSelect)
    }

    fun chooseMode(view: View) {
        val chooseModePVPPVC: Button = view as Button
        val lightbrown2 = getResources().getColor(R.color.lightbrown2, theme)
        val lightbrown = getResources().getColor(R.color.lightbrown, theme)
        when (chooseModePVPPVC.id) {
            R.id.PVP -> {
                setPlayer = 1
                chooseModePVPPVC.setBackgroundColor(lightbrown2)
                PVC.setBackgroundColor(lightbrown)
            }
            R.id.PVC -> {
                setPlayer = 2
                chooseModePVPPVC.setBackgroundColor(lightbrown2)
                PVP.setBackgroundColor(lightbrown)
            }
        }
    }


    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    var activePlayer = 1
    var setPlayer = 1

    private fun gamePlay(squareId: Int, buttonSelect: Button) {
        if (activePlayer == 1) {
            buttonSelect.text = "X"
            buttonSelect.setBackgroundColor(Color.RED)
            playerOne.add(squareId)
            activePlayer = 2
            if (setPlayer == 1) {
            } else {
                try {
                    playWithDevice()
                } catch (ex: Exception) {
                    Toast.makeText(this, "Game over", Toast.LENGTH_LONG).show()
                }

            }
        } else {
            buttonSelect.text = "O"
                buttonSelect.setBackgroundColor(Color.GREEN)
                playerTwo.add(squareId)
                activePlayer = 1
            }

            buttonSelect.isEnabled = false
            verifyWinner()
        }

        fun verifyWinner() {
            var winner = -1

            //rows
            if (playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)) {
                winner = 1
            } else if (playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)) {
                winner = 2
            }

            if (playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)) {
                winner = 1
            } else if (playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)) {
                winner = 2
            }

            if (playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)) {
                winner = 1
            } else if (playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)) {
                winner = 2
            }

            //diagonal
            if (playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)) {
                winner = 1
            } else if (playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)) {
                winner = 2
            }

            if (playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)) {
                winner = 1
            } else if (playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)) {
                winner = 2
            }

            //columns

            if (playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)) {
                winner = 1
            } else if (playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)) {
                winner = 2
            }

            if (playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)) {
                winner = 1
            } else if (playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)) {
                winner = 2
            }

            if (playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)) {
                winner = 1
            } else if (playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)) {
                winner = 2
            }

            if (winner == 1) {
                Toast.makeText(this, "Player One has won", Toast.LENGTH_SHORT).show()
            } else if (winner == 2) {
                Toast.makeText(this, "Player Two has won", Toast.LENGTH_SHORT).show()
            }

        }

        fun playWithDevice() {
            var emptySquare = ArrayList<Int>()
            for (squareId in 1..9) {
                if (!(playerOne.contains(squareId) || playerTwo.contains(squareId))) {
                    emptySquare.add(squareId)
                }
            }

            val randomCell = Random

            if (!emptySquare.isEmpty()) {
                val randomIndexer = randomCell.nextInt(emptySquare.size - 0) + 0
            } else {
                return
                Toast.makeText(this, "Game Ended", Toast.LENGTH_LONG).show()
            }
            val randomIndexer = randomCell.nextInt(emptySquare.size - 0) + 0
            val squareId = emptySquare[randomIndexer]
            var btSelector: Button?
            when (squareId) {
                1 -> btSelector = button
                2 -> btSelector = button2
                3 -> btSelector = button3
                4 -> btSelector = button4
                5 -> btSelector = button5
                6 -> btSelector = button6
                7 -> btSelector = button7
                8 -> btSelector = button8
                9 -> btSelector = button9
                else -> {
                    btSelector = button
                }
            }
            gamePlay(squareId, btSelector)


        }
    fun restartGame(view:View){
        button.setBackgroundResource(android.R.drawable.btn_default)
        button2.setBackgroundResource(android.R.drawable.btn_default)
        button3.setBackgroundResource(android.R.drawable.btn_default)
        button4.setBackgroundResource(android.R.drawable.btn_default)
        button5.setBackgroundResource(android.R.drawable.btn_default)
        button6.setBackgroundResource(android.R.drawable.btn_default)
        button7.setBackgroundResource(android.R.drawable.btn_default)
        button8.setBackgroundResource(android.R.drawable.btn_default)
        button9.setBackgroundResource(android.R.drawable.btn_default)

        button.text=""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        button.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        playerOne.clear()
        playerTwo.clear()
        activePlayer = 1
        setPlayer = 1

    }


    }

