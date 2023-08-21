// при отправке формы, в консоли выводить значения из инпутов

const form = document.querySelector("form") // Форма
const productName = document.querySelector(".product-name") // input Название
const productPrice = document.querySelector(".product-price") // input Цена
const productContainer = document.querySelector(".products") // section с продуктами

// бд
const products = [
    {
        name: "Iphone 12",
        price: 50000
    },
    {
        name: "Iphone 13",
        price: 60000
    },
]

form.addEventListener("submit", function(event) {
    event.preventDefault() // отмена перезагрузки страницы

    const newProduct = {
        name: productName.value,
        price: Number(productPrice.value) // "100" -> 100
    }
    products.push(newProduct) // добавляем новый продукт в массив или в бд
    clearInputs() // вызов функции очистки полей
    showProducts() // вызов функции отображения продуктов после добавления нового
})

// Функция очищения полей input после отправки формы 
function clearInputs() {
    productName.value = ""
    productPrice.value = ""
}

// Функция отображения продуктов //
function showProducts() {
    productContainer.innerHTML = "" // очищаем section перед добавлением новых продуктов
    products.forEach(function(product, index) {
        productContainer.innerHTML += `
                <div class="product-card">
                    <p class="product-card-name">${product.name}</p>
                    <p class="product-card-price">${product.price}</p>
                    <button class="delete-btn" id="${index}"> X </button>
                </div>
        `
    })
    onCardHover() // вызов эффекта при наведении
    deleteProduct() // вызов функции удаления элемента
}
showProducts() // первый вызов отображения продуктов, когда пользователь только зашел на страницу

// функция эффекта пояления крестика при наведении
function onCardHover() {
    const productsCards = document.querySelectorAll(".product-card") // [{}, {}]
    productsCards.forEach(function(card) {
        card.addEventListener("mouseover", function() {
            card.querySelector(".delete-btn").style.display = "block" // отображаем при наведении
        })
        card.addEventListener("mouseout", function() {
            card.querySelector(".delete-btn").style.display = "none" // скрываем при отведении
        })
    })
}

// Функция удаления продукта
function deleteProduct() {
    const deleteBtns = document.querySelectorAll(".delete-btn") // [{btn}, {btn}]
    deleteBtns.forEach(function(btn) {
        btn.addEventListener("click", function() {
            // удалить элемент из массива products
            const currentId = btn.id // получаем id кнопки, по которой кликнули
            products.splice(currentId, 1) // удаляем элемент, по которому кликнули из массива
            btn.parentElement.remove() // удаляем карточку из html

            showProducts() // после удаления, опять отображаем продукты
        })
    })
}
/*
    .parentElement - свойство, которое получает родительский элемент тега

    splice(id, num)
    Метод splice удаляет элемент из массива по индексу
     Первым аргуемнтом принимает индекс элемента
     Вторым аргуементом принимает количество элементов, которые нужно удалить

     const names = ["Arsen", "Lana", "Vladyslav"]
     names.splice(1, 2) // ["Arsen", "Vladyslav"]

*/

// mouseover - при наведении на элемент
// mouseout -  при отведении от элемента

/*
    for - низкоуровневый цикл. задаем параметры для того, чтобы пройтись циклом по массиву
        инициализация, условие, шаг
    
    forEach - высокоуровневый, больше похож на человеческий язык

    array.forEach(function(item, index, array) {
        console.log(item)
    })
    метод forEach вызовет переданную коллбек функцию столько раз сколько элементов в массиве array?
        при этом функция принимает 3 параметра
        1. item - каждый элемент в массиве. первый раз функция выполнится и получит первый элемент массива
            второй раз получить второй элемент массива и т д 
        2. index - это порядковые номер элемента в массиве array[0], array[1]
        3. array - это сам массив
*/

/*
        section.innerHTML += `<div>${array[i].name}</div>`

    <div class="product-card">
            <p class="product-card-name">Сноуборд</p>
            <p class="product-card-price">10000</p>
    </div>
    <div class="product-card">
        <p class="product-card-name">Сноуборд</p>
        <p class="product-card-price">10000</p>
    </div>

     value - свойство input, в котором хранится введеное пользователем значение 
*/
