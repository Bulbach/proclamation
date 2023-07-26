function applyHandler(formElement) {
   const data = $(formElement).serializeArray();
   const obj={};
   for (const field of data){
      obj[field.name]= field.value;
   }
   const $btn = $(formElement).find(".btn-primary").button('loading');
   $(formElement).find('.form-group').removeClass("has-error");
   $(formElement).find('.form-group .help-block').text('');
   $.ajax({
      url: '/mail/send',
      type: 'POST',
      data: JSON.stringify(obj),
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      success: function (msg) {

         if (msg.statusCode === 400){
            $.growl.error({title:"Ошибка" ,message: "Проверьте введенные данные" });
               console.log(msg.violations)
            msg.violations.forEach(function (vio){
               $(formElement).find(`input[name="${vio.fieldName}"]`).parent().addClass("has-error");
               $(formElement).find(`input[name="${vio.fieldName}"]`).next(".help-block").text(vio.message)
            });
         }
         else if(msg.statusCode===303){
            $('.modal').modal('hide');
            $.growl.error({title:"Неудача" ,message: msg.message });
         }
         else {
         $('.modal').modal('hide');
            $.growl.notice({title:"Успех" ,message: msg.message });
         }
      },
      complete: function (){
         $btn.button('reset')
      },
      error: function (msg) {
         $.growl.error({title:"Неудача" ,message: "Что-то пошло не так! Попробуйте ещё раз позже" });
      }
         });
   return false;
}
