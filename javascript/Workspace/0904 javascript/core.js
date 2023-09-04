
/*  //1. 자바스크립트의 기본 데이터 타입    
        number, string, boolean, null, undefined, obejct, symbol, bigint
        배열도 함수도 object
        null : 값이 없음을 명시적으로 지정할 때 사용
        undefined : 값을 저장한 적이 없는 변수의 값  선언 후 초기화 안한거 객체의 존재하지 않은 속성값
        console.log(typeof null); //object
        console.log(typeof function(){}); //function

    //2. ==연산자와 ===연산자 차이
        ==	왼쪽 피연산자와 오른쪽 피연산자의 값이 같으면 참을 반환함.
        ===	왼쪽 피연산자와 오른쪽 피연산자의 값이 같고, 같은 타입이면 참을 반환함.
         console.log(123 == '123');
         console.log(123 === '123');
         console.log(null == undefined);
         console.log(null === undefined);

         == 명시적으로 형변환을 하여, 타입이 일치하는 대상끼리 비교 권장
         명시적으로 형변활할때, 타입이름으로 된 함수를 사용

         console.log(string(123) == '123');
         console.log(123 == Number('123'));

    //3. 변수선언시 사용하는 var, let, const 차이

    var 함수범위(함수안에서사용 함수 없으면 어디서든가능) 변수 변수 재선언 가능
    let 블록범위(자기를 감싼 가장 가까운 중괄호) 변수 변수재선언 불가능 변수 재할당 가능
    const 블록범위 상수 변수재선언 불가능 변수 재할당 불가능 

    if(true){
        var x = 1;
        let y = 2;
        console.log(x,y);
    }
    console.log(x); //o
    console.log(y); //x
    y = 3; //전역변수 생성됨
    console.log(y); //ㅇ


    //4. 아래 명령문에서 변수 C에 저장될 수 있는 값의 종류
        // var c = a && b; 
        a를 불린으로 평가했을때 true이면 b false이면 a
        // var c = a || b;
        a를 불린으로 평가했을때 true이면 a false이면 b
        boolean 으로 형변환시 false로 변환되는 값  : 숫자 0, NaN(Not A Number)
                                                   빈문자열, '', null, undefined
    console.log(1 && 2); //2
    console.log(1 || 2); //1
    console.log('가나다' && '마바사'); //마바사
    console.log('가나다' || '마바사'); //가나다
    console.log(Booolean('0'));
    console.log(Booolean(''));
*/

const { values } = require("core-js/es/array");

    //5. prompt 명령으로 숫자를 입력받아서 콘솔에 출력하는 프로그램 
    //(숫자가 아닌 값을 입력하면 숫자를 입력 할 때까지 반복)
    // alert(단순출력), confirm(참거짓), prompt(문자열입력)

   /* function readNumber() {
        let num;
      
        do {
          num = prompt("Enter a number please?", 0);
        } while ( !isFinite(num) ); // (isNaN(num))이라고 해도 됨
      
        if (num === null || num === '') return null; 
      
        return +num; // 숫자형 값이어야 하니 + 추가
      }
      
      alert(`Read: ${readNumber()}`);*/
    //6. 두수의 합을 반환하는 함수 sum
      
      console.log(sum(3,4)); 

      function sum(a,b) {return a+b;}
      
        var summ = function(x,y){
          return x+y; 
        } //호이스팅 변수 선언문만 맨위로 간다 
        console.log(summ(3,4)); 
        
        var summm = new Function('x', 'y', 'return x+y;'); //매개변수이름들과 함수본문내용을 문자열 인자로 전달
        console.log(summm(3,4)); 
        //람다식 1. function 키워드 대신 => 
        //2.매개변수 개수가 1개뿐이면 () 생략가능 
        //3. 함수본문내용이 return 문 1개 뿐이라면, {return} 생략 가능
        
        var summmm = (x,y) => x+y;
        console.log(summmm(3,4)); 
        console.log(summmm(3)); //NaN 
        console.log(summmm(3,4,5,6));  //호출되나 뒷자리 무시됨

 
      /*do{
        var v = prompt('숫자를 입력하세요');
        var n = Number(v); // 숫자가 아닌값을 숫자로 변환하면 NaN
      } while (isNaN(n)); //NaN 값 확인(비교)는 비교연산자가 아닌 isNaN() 함수사용
      console.log(n);'
    
    

      
      
      //7. 모든 인자들의 총합을 반환하는 함수 total
      인자 갯수 제한 없음  
 */
        function total() {
            var result = 0;
            for(var i in arguments){
            result += arguments[i];
            }
            return result;
            }
                        console.log(total(3,4,5)); 
                        console.log(total(1,2,3,4)); 
                        console.log(total(1,2,3,4,5,6));
        
        function totall(...z){ //나머지 매개변수를 배열로 받을 수 있다 새로등장한 문법
            let n = 0;
            for (let j = 0; j < z.length; j++){
                n += z[j];
            }
            return n;
        }

        console.log(totall(3,4,5)); 
        console.log(totall(1,2,3,4)); 
        console.log(totall(1,2,3,4,5,6));

    //8. 정수 3,6,9,12,15를 담은 배열 nums를 생성
    //var nums = [3,6,9,12,15];
    //var nums = new Array(3,6,9,12,15);
    //var nums = Array(3,6,9,12,15); 비추천
        var ums = [];
        ums[0] = 3; // [3]
        ums[1] = 6; //[3,6]
        ums.push(9); //[3,6,9] 맨마지막 넣기 pop  맨마지막 꺼내기 배열에서 사라짐
        ums.unshift(1); //[1,3,6,9] 맨앞에 넣기  shift 맨 앞 빼기 
        ums.shift(1); //[3,6,9] 맨앞에 넣기  shift 맨 앞 빼기 
        ums.push(15); //[3,6,9,15] 맨마지막 넣기 pop  맨마지막 꺼내기 배열에서 사라짐
        ums.splice(3,0,12); //[3,6,9,12,15] 인덱스 3 자리 지우지 말고 12 넣어라 
        console.log(ums);

        const nums = [3,6,9,12,15];
        console.log(nums); //[3,6,9,12,15]


    //nums 배열의 각 요소들을 ()로 감싸서 출력 (3)(6)(9)(12)(15)
        const numss = [3,6,9,12,15];
        numss.forEach((num) => console.log(`(${num})`));
        numss.forEach((num) => console.log('('+num+')'));
        console.log(numss.toString());
        console.log('('+numss.join(')(')+')');


    //nums 배열의 각 요소에서 6을 뺀 값들을 담은 배열 nums2 생성
        const array = [3,6,9,12,15]
        const numsss = n => n-6;
        const nums2 = array.map(numsss);
        console.log(nums2)

        var nums4 = nums.map(v=>v-6);
        console.log(nums4);
    // console.log (nums2); //[-3,0,3,6,9]

    //nums 배열의 총합을 출력
        var m =0;
        for (let i=0; i<nums.length; i++){
            m+= nums[i];
        }
        console.log(m);

        var h = nums.reduce((prePresult,v) =>prePresult + v,0);
            //직전에 실행했던 함수의 반환값(결과값을)을 첫번째 인자로 전달
            //함수 최초 실행시 이전 함수실행결과값으로 전달될 값을 지정 (두번째인자 0은 최초값 명시해주기)
        console.log(h);
    
    //nums 배열 요소에서 짝수인 요소만 담은 배열 nums3 생성
    function checkEvenNumber(m) {
        let remainder = m % 2;
        if(remainder === 0) {
         return true;
        } 
      return false;
     }
     
     const myArr = [3,6,9,12,15];
     let oddArr = [];
     myArr.forEach(element => {
         if(checkEvenNumber(element)) {
             oddArr.push(element);
         }
     })
     console.log(oddArr.toString()); 
       // console.log(num3); //[6,12]

    var nums3 = [];
    for(let i =0; i < nums.length; i++){
        if(nums[i]%2===0){
            nums3.push(nums[i]);
        }
    }
    nums.filter(function(v,i,arr){
        if (v%2===0) return true;
        else false;
    });
    var nums5 = nums.filter(v=>v%2===0);
    console.log(nums3);
    console.log(nums5);


    //nums 배열의 모든 요소가 0보다 크면 '양수', 그렇지 않으면 '정수' 출력
    var flag = true;
    for(let i = 0; i <nums.length; i++){
        if(nums[i]<=0){
            flag=false;
            break;
        }
    }
    nums.every(function(v,i,arr){
        return v>0;

    });

    if(flag)console.log('양수');
    else console.log('정수');

    var flag2 = nums.every((v)=>v>0);
    if(flag2)console.log('양수');
    else console.log('정수');

    //nums2 배열의 모든 요소가 0보다 크면 '양수', 그렇지 않으면 '정수' 출력
    if(nums2.every((v)=>v>0))console.log('양수');
    else console.log('정수');
    //nums 배열의 요소들 중 0이 하나라도 있으면 '포함', 그렇지 않으면 '미포함' 출력
    flag3 = false

    flag = nums.some(function(v,i,arr){
        return v===0;
    });
    flag3 =nums.some(v=>v===0);
    if(flag3)console.log('포함');
    else console.log('미포함');
    //nums2 배열의 요소들 중 0이 하나라도 있으면 '포함', 그렇지 않으면 '미포함' 출력
  
    if(nums2.some(v=>v===0))console.log('포함');
    else console.log('미포함');

    //인자를 1개만 전달하면 다른 인자의 값은 0으로 설정하여 결과를 출력하도록
    //함수 sum을 재정의하세요
    function summmmmm(x,y=0){
        return x+y;
    }
    console.log(summmmmm(3)); //3

    sumn =function(x,y){
        if(y===undefined) y=0;
        y =y||0;
        return x+y;
    }
    console.log(sumn(3));

    //속성 x의 값이 1이고,속성 y의 값이 2이며
    //원점으로부터 거리를 반환하는 dist() 메서드를 가진 객체를 변수 p에 저장

    //객체 생성 방법 
    /*var obj = {};
    var obj = new Object();
    var obj = Object(); //비추천
    var obj = Object.create(Object.prototype);*/


    var p = { 
        x:1, 
        y:2,
        dist: function(){
            return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
        }
    };
    console.log(p.x);
    console.log(p.y);
    console.log(p.dist());

    //객체 p의 모든 속성과 속성값들을 출력하세요.
    for(let pname in p){ //객체 p의 속성이름을 하나씩 pname에 저장하면서 반복
        console.log(pname, p[pname]);}

    function Point(){
        this.x =1;
        this.y =2;
        this.dist =function(){
            return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
        };
    }
    /* new 함수()
    -새롭게 빈 객체 ({})를 생성하고
    -그 객체를 this로 설정한 상태에서 함수를 실행한 후,
    그 객체를 반환 */
   
    /*var p = new Point();
    var p1 = new Point(1,2);
    var p2 = new Point(3,4);
    var p3 = new Point(5,6);*/

    //값 이외에 다양한 속성의 작동방식을 설정하고 싶은 경우,
    //Object .create()명령문 사용 가능
    //var p = Object .create(Object.prototype,{
    //    x: {value:1, writeable:tru, },
    //    y: {value:2} 

    function Car(m,s) {
        this.model = m;
        this.speed = s;
        this.accel = function(){
            this.speed += 10;
        }
        this.brake = function(){
            this.speed -= 10;
        }
    }
    Car.prototype.accel = function() {
        this.speed += 10;
    } ;
    Car.prototype.brake = function() {
        this.speed -= 10;
    } ;

    var c1 = new Car("Ray", 60);
    console.log(c1.model); //"Ray"
    console.log(c1.speed); //"60"
    c1.accel(); //속도 10 증가 
    console.log(c1.speed); //70
    c1.brake(); //속도 10- 감소
    console.log(c1.speed); //60
    var c2 = new Car("Soul", 40);
    console.log(c2.model); //"soul"
    console.log(c2.speed); //"40"
    c2.accel(); //속도 10 증가 
    console.log(c2.speed); // 50
    c2.brake(); //속도 10- 감소
    console.log(c2.speed); //40


    var pobj = { a: 1, b: 2 };
    var cobj = { b: 3, c: 4};
    //cobj.__proto__=pobj; //객체에는 부모객체를 저장하는 속성 존재
    Object.setPrototypeOf(cobj, pobj); //cobj객체의 부모객체로 pobj를 설정
    console.log(cobj.a, cobj.b, cobj.c);

    function Child(){
        this.b = 3;
        this.c = 4;
        // this.__proto__=pobj;
        // Object.setPrototypeOf(this, pobj);

    }
    Child.prototype = pobj; //생성자 함수로 생성
    var cobj1 =new Child();
    var cobj2 =new Child();
    console.log(cobj1.a, cobj1.b, cobj1.c);
    console.log(cobj2.a, cobj2.b, cobj2.c);

    //모든 객체에 tmi 메서드를 추가하세요
    //객체.tmi( )메서드를 실행하면 ,콘솔에 "제가 1994년 LA에 있었을때"라고 출력

   Object.prototype.tmi= function(){
        console.log('제가 1994년 LA에 있었을때...')
    }

    p.tmi(); // "제가 1994년 LA에 있었을때"
    cobj.tmi(); // "제가 1994년 LA에 있었을때"
    ({}).tmi(); // "제가 1994년 LA에 있었을때"

    //모든 배열에 remove 메서드를 추가하세요
    //배열.remove(1) 메서드를 실행하면, 배열의 1번 요소를 삭제
    

    Array.prototype.remove = function(i){
        this.splice(i,1);
        
    };

    nums.remove(2);
    console.log(nums); //[3,6,12,15]

    //모든 배열에 each, mymap 메서드를 추가하세요
    //each 메서드는 forEach 메서드와 동일한 작업을 수행
    // mymap 메서드는 map 메서드와 동일한 작업을 수행

    Array.prototype.each = function (callback, context) {
        for (let i = 0; i < this.length; i++) {
            callback.call(context || null, this[i], i, this);
        }
    };

    nums.each(v => console.log('('+ v + ')') ); //(3) (6) (12) (15)

    Array.prototype.mymap = function (callback, context) {
        const arr = [];
        for (let i = 0; i < this.length; i++) {
            arr.push(callback.call(context || null, this[i], i, this));
        }
        return arr;
    };

    console.log(nums.mymap(v=> v-6)); //[-3,0,6,9]

    var prodList = [];
    prodList.push( {no:1, name:'인디언밥', price: 500, sale: 0.1} );
    prodList.push( {no:2, name: '고래밥', price: 800, sale: 0.2} );
    prodList.push( {no:3, name: '사또밥', price: 200, sale: 0.3} );

    //prodList 저장되어 있는 상품들의 상품명과 할인된가격을 콘솔에 출력
   
       for (let i = 0; i < this.length; i++) {
           const p = prodList[i];
           console.log(p.name, p.price*(1-p.sale));
        } 
       for(var pp of prodList){
            console.log( pp.name, pp.price*(1-pp.sale) );
       }
        prodList.forEach((e)=>{
            console.log(e.name, e.price*(1-e.sale));
        });


    //정가가 500이하인 상품들의 할인된 가격의 총합을 출력
    var t = 0;
    for (let i = 0; i < prodList.length; i++) {
        const p = prodList[i];
        if(p.price<=500)
        t += p.price*(1-p.sale);
     } 
     console.log(t);

     console.log(
     prodList.filter(p=>p.price<=500)
             .map(p=>p.price*(1-p.sale))
             .reduce((pv,v,i,arr)=>pv+v,0)
             );

    var studentList = [];
    studentList.push({ no: '202301', rates: [5,4,3,4,5]});
    studentList.push({ no: '202302', rates: [5,5,2,5,5]});
    studentList.push({ no: '202303', rates: [4,3,3,3,5]});
    studentList.push({ no: '202304', rates: [5,4,1,4,5]});
    studentList.push({ no: '202305', rates: [3,4,3,4,3]});
    //각 학생 객체에 rates를 100점 만점 점수로 환산한 결과를 담은 scores 속성 추가

    const scores = studentList.map(student => ({
        no: student.no,
        scores: student.rates.map(x => x * 10 + 54)
      }));
      
      console.log(scores);

     for(let i =0; i <studentList.length; i++ ){
        const s =studentList[i];
        s.scores =s.rates.map(v=>v*20);
        s.total = 0;
        s.pass = true;
        s.top = false;
/*         for (let j = 0; j <s.rates.length; j++){
            s.scores[j] = s.rates[j] *20;
            s.total += s.scores[j];
            if(s.scores[j]<60) s.pass = false;
            if(s.scores[j]>=90) s.top = true;
        }  */
        s.scores =s.rates.map(v=>v*20);
        s.total = s.scores.reduce((pv, v)=>pv+v,0);
        s.pass = s.scores.every(v=>v>=60);
        s.top = s.scores.some(v=>v>=90);
     } 
     console.log(studentList);

