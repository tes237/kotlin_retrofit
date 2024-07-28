    inline fun <reified T> T.logi(message: String) = Log.i(T::class.java.simpleName, message)

    companion object
    {
        private const val TAG = "MainActivity"
    }

    //lateinit var isScreen : String
    //lateinit val isNormal
    //var nCount : Int? = null

//    val initVal : Int by lazy {
//        isScreen = "111"
//        20
//    }

//    fun sum(no : Int) : Int
//    {
//        var sum = 0
//        for (i in 1..no)
//        {
//            sum += i
//        }
//        return sum
//    }
//
//    fun testRet1(aa : String)
//    {
//
//    }
//
//    fun testRet2(aa : String) : Unit
//    {
//    }

//    val not001 : Nothing? = null

//    var intArray : Array<Int> = Array(10, { 0 })

//    var list : List<Int> = listOf<Int>(10, 20, 30)
//    var mutableList1 : MutableList<Int> = mutableListOf<Int>(0, 10, 20)

    //var intArray2 : Array<String> = arrayOf<String>("aaa", "bbb", "ccc")

    //var mapTest : Map<String, String> = mapOf<String, String>("one" to "Tom", "two" to "Steven", "test" to "real")

//    fun isRealVal(aaa : Boolean) : Boolean
//    {
//        if (aaa == true)
//        {
//            return true
//        }
//        else
//        {
//            return false
//        }
//
//        return true
//    }


//    var data = 10
//
//    when(data)
//    {
//        10 -> println("data is 10")
//        20 -> println("data is 20")
//        else ->
//        {
//            println("data is 30")
//        }
//    }

//    var data : Any = 10
//
//    when(data)
//    {
//        is String -> logi("data is String")
//        20, 30 -> logi("data is 20 or 30")
//        in 1..10 ->logi("data is 1<= <=10")
//        else -> logi("not valid data")
//    }


//    var data = 10
//
//    val result = when
//    {
//        data <= 0 -> "data is <= 0"
//        data > 100 -> "data is > 100"
//        else -> "data is valid"
//    }
//
//    println(result)

//    var tmpArray : Array<Int> = arrayOf(10, 20, 30)
//    logi("${tmpArray.indices}")
//
//    for (i in tmpArray.indices)
//    {
//        logi("${tmpArray[i]}")
//
//        if (i !== tmpArray.size -1)
//        {
//            print(",")
//        }
//    }

//    var tmpArray : Array<Int> = arrayOf(10, 20, 30)
//
//    for((index, valueInt) in tmpArray.withIndex())
//    {
//        logi("${valueInt}")
//
//        if (index !== tmpArray.size -1)
//        {
//            logi(",")
//        }
//    }

//    class UserData
//    {
//        var nameStr = "king"
//
//        constructor(name : String)
//        {
//            this.nameStr = name
//        }
//
//        fun getResule() : String
//        {
//            return nameStr
//        }
//
//        class ActionClass
//        {
//
//        }
//    }
//
//    val userData = UserData("park")
//    val ret = userData.getResule();

//    class User(name: String, count: Int)
//    {
//        var mmm = ""
//
//        init
//        {
//            this.mmm = "222"
//        }
//    }
//
//    val u = MainActivity.User("aaa", 3)

//    class UserData2(id : String)
//    {
//        var testStr = ""
//
//        constructor(id : String, count: Int) : this(id)
//        {
//            testStr = id
//
//        }
//    }
//
//    val user = UserData2("111", 333)

//    open class Animal(name : String)
//    {
//
//    }
//
//    class Insect(name : String) : Animal(name)
//    {
//
//    }
//
//    class Fish : Animal
//    {
//        constructor(name : String) : super(name)
//        {
//
//        }
//    }


//    open class Animal(name : String)
//    {
//        var animalName = "111"
//
//        fun fetchAnimalName() : String
//        {
//            return this.animalName
//        }
//    }
//
//    class Insect(name : String) : Animal(name)
//    {
//        var insectName = "222"
//
//        fun fetchInsectName() : String
//        {
//            return this.insectName
//        }
//    }

//    class Butterfly : Insect
//    {
//        constructor(name : String) : super(name)
//        {
//
//        }
//    }

//    val fly = Insect("bbb")
//
//    var ret1 = fly.fetchInsectName();
//    logi("${fly.insectName}")
//
//    var ret2 = fly.fetchAnimalName();
//    logi("${fly.animalName}")


//    open class Super
//    {
//        var publicData = 10
//        protected var protectedData = 20
//        private var privateData = 30
//    }
//
//    class Sub : Super()
//    {
//        fun subFun()
//        {
//            publicData++;
//            protectedData++;
//            privateData++;
//        }
//    }
//
//
//    var obj = Super()
//    obj.publicData++
//    obj.protectedData++
//    obj.privateData++

//    data class SerVerVO(val key : String, val id : String)
//
//    val non1 = SerVerVO("1111", "2222")
//    val non2 = SerVerVO("1111", "2222")
//    val data1 = SerVerVO("3333", "4444")
//    val data2 = SerVerVO("4444", "5555")
//
//    logi("data class equals :  ${data1.equals(data2)}")
//    logi("data class equals :  ${non1.equals(non2)}")

//    lateinit var tmpText1 : TextView
//    lateinit var tmpText2 : TextView
//    lateinit var tmpImage1 : ImageView
//
//
////        tmpText1 = findViewById(R.id.tv_001)
////        tmpImage1 = findViewById(R.id.iv_001)
////        tmpText2 = findViewById(R.id.tv_002)
//
//    tmpText1 = TextView(this).apply {
//    typeface = Typeface.DEFAULT_BOLD
//    text = "Lake Lousie"
//}
//
//    tmpImage1 = ImageView(this).also {
//    it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background))
//}
//
//    tmpText2 = TextView(this).apply {
//    typeface = Typeface.DEFAULT_BOLD
//    text = "New York"
//}
//
//    val tmpLayout = LinearLayout(this).apply {
//        orientation = LinearLayout.VERTICAL
//        gravity = Gravity.CENTER
//        addView(tmpText1, WRAP_CONTENT, WRAP_CONTENT)
//        addView(tmpText2, WRAP_CONTENT, WRAP_CONTENT)
//        addView(tmpImage1, WRAP_CONTENT, WRAP_CONTENT)
//    }
//
//    setContentView(tmpLayout)



//    val sumfunc = {
//            num1 : Int, num2 : Int ->
//        num1 + num2
//    }
//
//    val ret = sumfunc(100, 200)

//    val sumfunc = {
//            num1 : Int, num2 : Int ->
//        logi("hello")
//        num1 * num2
//    }
//
//    val ret = sumfunc(3, 5)


//    val lmdShow = { ->
//        logi("1111")
//    }
//
//    lmdShow()

//    val someFunc : (Int, String) -> Boolean = { idVal : Int, name : String ->
//        if(idVal == 0)
//        {
//            true
//        }
//        else
//        {
//            false
//        }
//    }
//    val ret1 = someFunc(0, "abc")
//    val ret2 = someFunc(1, "abc")


//    var name : String? = null
//
//    val length = if(name == null)
//    {
//        0
//    }
//    else
//    {
//        name.length
//    }
//
//    logi("${length}")

//
//    var name : String? = null
//
//    logi("name length : ${name?.length ?: 0}")
//    logi("name length : ${name?.length}")


//    fun checkFunc(name : String?) : Int
//    {
//        return name!!.length
//    }
//
//    logi("${checkFunc("aaa")}")
//    logi("${checkFunc(null)}")  //null pointer Exception
