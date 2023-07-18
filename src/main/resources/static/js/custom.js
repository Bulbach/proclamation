function applyHandler(formElement) {
   const data = $(formElement).serializeArray();
   console.log(formElement,data)
   $.ajax({
      url: 'Ajax.ashx',
      type: 'POST',
      data: JSON.stringify(data),
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      success: function (msg) {
         alert(msg);
      },
      error: function () {
         alert("Something wrong!");
      }
         });
   return false;
}
