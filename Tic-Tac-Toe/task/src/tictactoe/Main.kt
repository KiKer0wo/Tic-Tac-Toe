package tictactoe


var x = 0
var o = 0
var cordX = 0
var cordY = 0
var checkWinner = true

fun main() {



    val array = Array(5) { CharArray(9) }
    for (i in 0..4) {
        for (j in 0..8) {
            array[i][j] = ' '
        }
    }

    generateGame(array)
    display(array)
    print("Enter the coordinates: ")
    do {
        do {
            val (cord1, cord2) = readLine()!!.split(' ')
            var check = true
            if (cord1.toIntOrNull() == null || cord2.toIntOrNull() == null) {
                check = false
                println("You should enter numbers!")
            } else if (!(cord1.toInt() in 1..3 && cord2.toInt() in 1..3)) {
                println("Coordinates should be from 1 to 3!")
                check = false
            } else if (!(checkIfNotEmpty(array, cord1.toInt(), cord2.toInt()))) {
                println("This cell is occupied! Choose another one!")
                check = false
            } else {
                cordX = cord1.toInt()
                cordY = cord2.toInt()
                assignsCords(array, cordX, cordY)
                display(array)
            }
        } while (!check)


        if(!checkX(array)){
            println("X wins")
            checkWinner = false

        } else if(!checkY(array)){
            println("O wins")
            checkWinner = false
        } else if(!checkEmpty(array)){
            println("Game not finished")
        }

    } while(checkWinner)
    if(checkWinner) println("Draw")



    if(!checkX(array)){
       println("X wins")

   } else if(!checkY(array)){
       println("O wins")
   } else if(!checkEmpty(array)){
       println("Game not finished")
    }
    else println("Draw")

}

    fun display(array: Array<CharArray>){
        for (i in 0..4) {
            for (j in 0..8) {
                print("${array[i][j]}")
            }
            println()
        }
    }


fun generateGame(array: Array<CharArray>){
    for(i in 0..8){
        array[0][i]='-'
        array[4][i]='-'
    }
    for(i in 1..3){
        array[i][0] = '|'
        array[i][8] ='|'
    }
    for(i in 2..6 step 2){
        for(j in 1..3){
            array[j][i]='_'
        }
    }
}

fun assignsCords(array:Array<CharArray>,cord1:Int,cord2:Int){
    if(cord2==1){
        array[cord1][2]='X'
    } else if(cord2==2){
        array[cord1][4]='X'
    } else if(cord2==3){
        array[cord1][6]='X'
    }

}

fun checkX(array: Array<CharArray>): Boolean {
    if(array[1][2]=='X' && array[1][4]=='X' && array[1][6]=='X'){
        return false
    }
    else if(array[2][2]=='X' && array[2][4]=='X' && array[2][6]=='X'){
        return false
    }
    else if(array[3][2]=='X' && array[3][4]=='X' && array[3][6]=='X'){
        return false
    }
    else if(array[1][2]=='X' && array[2][2]=='X' && array[3][2]=='X'){
        return false
    }
    else if(array[1][4]=='X' && array[2][4]=='X' && array[3][4]=='X'){
        return false
    }
    else if(array[1][6]=='X' && array[2][6]=='X' && array[3][6]=='X'){
        return false
    }
    else if(array[1][2]=='X' && array[2][4]=='X' && array[3][6]=='X'){
        return false
    }
    else if(array[1][6]=='X' && array[2][4]=='X' && array[3][2]=='X'){
        return false
    }
    return true
}

fun checkY(array: Array<CharArray>): Boolean {
    if(array[1][2]=='O' && array[1][4]=='O' && array[1][6]=='O'){
        return false
    }
    else if(array[2][2]=='O' && array[2][4]=='O' && array[2][6]=='O'){
        return false
    }
    else if(array[3][2]=='O' && array[3][4]=='O' && array[3][6]=='O'){
        return false
    }
    else if(array[1][2]=='O' && array[2][2]=='O' && array[3][2]=='O'){
        return false
    }
    else if(array[1][4]=='O' && array[2][4]=='O' && array[3][4]=='O'){
        return false
    }
    else if(array[1][6]=='O' && array[2][6]=='O' && array[3][6]=='O'){
        return false
    }
    else if(array[1][2]=='O' && array[2][4]=='O' && array[3][6]=='O'){
        return false
    }
    else if(array[1][6]=='O' && array[2][4]=='O' && array[3][2]=='O'){
        return false
    }
    return true
}

fun checkEmpty(array: Array<CharArray>):Boolean {
    for (i in 1..3) {
        for (j in 2..6 step 2) {
            if (array[i][j] == '_') {
                return false
            }
        }
    }
    return true
}

fun checkIfNotEmpty(array:Array<CharArray>,cord1:Int,cord2:Int):Boolean{
    when (cord2) {
        1 -> {
            if(array[cord1][2]=='X' || array[cord1][2]=='O' ){
                return false
            }
        }
        2 -> {
            if(array[cord1][4]=='X' || array[cord1][4]=='O' ){
                return false
            }
        }
        3 -> {
            if(array[cord1][6]=='X' || array[cord1][6]=='O' ){
                return false
            }
        }
    }
    return true
}