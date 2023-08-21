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
    clearInputs()
    showProducts()
})

function clearInputs() {
    productName.value = ""
    productPrice.value = ""
}
function showProducts() {
    productContainer.innerHTML = ""
    products.forEach(function(product, index){
        productContainer.innerHTML += `
                <div class="product-card">
                    <p class="product-card-name">${product.name}</p>
                    <p class="product-card-price">${product.price}</p>
                    <button class="delete-btn" id="${index}"> X </button>
                </div>
        `
    })
    onCardHower()
    deleteProduct()
}
showProducts()

function onCardHower() {
    const productsCards = document.querySelectorAll(".product-card")
    productsCards.forEach(function(card) {
        card.addEventListener("mouseover", function() {
            card.querySelector(".delete-btn").style.display = "block" //отображаем при наведении
        })
        card.addEventListener("mouseout", function() {
            card.querySelector(".delete-btn").style.display = "none" //скрываем при отведении
         })
})
}

function deleteProduct() {
    const deleteBtns = document.querySelectorAll(".delete-btn") // [{btn}, {btn}]
    deleteBtns.forEach(function(btn) {
        btn.addEventListener("click", function() {
            const currentId = btn.id
            products.splice(currentId, 1)
            btn.parentElement.remove()

            showProducts()
        })
    })
}


products.forEach(function(product){
    productContainer.innerHTML += `
    <div class="product-card">
        <p class="product-card-name">${products[i].name}</p>
        <p class="product-card-price">${products[i].price}</p>
    </div>
`
})


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

/*  <div class="product-card">
            <p class="product-card-name">Сноуборд</p>
            <p class="product-card-price">10000</p>
        </div>
        <div class="product-card">
            <p class="product-card-name">Велосипед</p>
            <p class="product-card-price">10000</p>
        </div> */

/*
    splice(id, num)
    Метод splice удаляет элемент из массива по индексу
     Первым аргуемнтом принимает индекс элемента
     Вторым аргуементом принимает количество элементов, которые нужно удалить

     const names = ["Arsen", "Lana", "Vladyslav"]
     names.splice(1, 2) // ["Arsen", "Vladyslav"]

*/