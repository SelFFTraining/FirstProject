class Practise1 {

    static int matrix=5
    static Map<String,Integer> tableData = new HashMap<String,Integer>()
    static void main(String[] args){

        int midRow=Math.ceil(matrix/2)
        int currentRow=midRow
        int currentCol=matrix


        processMagicSquare(currentRow,currentCol,1)
println("check")




    }

    static void processMagicSquare(row, col, num){


        //If current cell doesn't have data set it and move to next cell
        if(isValidCell(row,col) && getTableData(row,col)==null) {
            storeData(row, col, num)
            row=row-1
            col=col+1
            processMagicSquare(row,col,num+1)

        }
        else if(isValidCell(row,col) && getTableData(row,col)!=null) {
            processMagicSquare(row+1,col-2,num)
        }
        //Check if next cell exists
        else if(col>matrix) {
            if(row==1) {
                processMagicSquare(1,1,num)//1,4 value 2

            }else if (row<1){
                processMagicSquare(row+1,col-2,num) // 0,4 value 7
            }
            else {
                processMagicSquare(row,1,num) // 2,4 value 9
            }

        }else if(row<1){

            processMagicSquare(matrix,col,num) // 1,2 value 7
        }else{
            return
        }


    }

    static boolean isValidCell(row,col){
       return (row>=1 && row<=matrix && col>=1 && col<=matrix)? true :false
    }
    static void storeData(row, col, value){
        tableData.put(row+"##"+col,value)
    }
    static String getTableData(row, col){
        return tableData.get(row+"##"+col)
    }
    static void printCellValue(row, col, value){
        String cell ="("+row+","+col+")"+value
        print(cell)
        print("\t")
    }
}
