# MovieTest

Тестовое задание.
=====================
Приложение показывает отсортированные данные с API - "https://raw.githubusercontent.com/constanta-android-dev/intership-wellcome-task/main/films.json"

Архитектура
=====================

* presentation
  * single activity
  * List(fragment + viewModel + listAdapter)
  * errorFragment
* domain
  * movieRepository
* data
  * movieRepository - реализация
  * apiProvider
  
  List Fragment
  =====================

<img src="https://user-images.githubusercontent.com/105432796/183271846-d608e982-778f-4ac6-b1f9-f7980cd62b8a.jpg" width="400" />   <img src="https://user-images.githubusercontent.com/105432796/183271849-5b858d5d-014e-4c7a-b745-50bd3f7e49d7.jpg" width="400" />

  Error Fragment
=====================

<img src="https://user-images.githubusercontent.com/105432796/183271854-123adb81-28d7-4080-aefc-1fb5a3b0e145.jpg" width="400" />

  Use case:
  -----------------------------------

* Получить данные с сервера
* Отсортировать данные по году выпуска




Использованные технологии:
=====================
1. Google Navigation
2. Material Design
3. Retorfit
4. ViewBinding
5. Hilt
6. Coroutine
