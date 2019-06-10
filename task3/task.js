$(document).ready(function() {
  /* when form is submitted */
  $('.form').submit(function(){
    $('#res').html(" "); // set innerHtml of res div as blank
    callWikipedia();
    return false;
  });
  /* when search button is clicked */
  $('#search').click(function(){
    $('#res').html(" ");
    callWikipedia();
  });
  function callWikipedia(){
    var q = $('#query').val();
    var url = "http://en.wikipedia.org/w/api.php?format=json&action=query&generator=search&prop=pageimages|extracts&pilimit=max&exintro&explaintext&exsentences=1&exlimit=max&gsrsearch="+q+"&callback=?";
    $.ajax({
      url:url,
      type: 'POST',
      dataType: 'json',

      success: function(result){
        var err=result.continue;
      if(err){
        console.log(result);
        var data = result.query.pages;
       
       render(data);

      }
      else{
        
        alert('Please try again. Search words are not available.');
       }
      }
    });
  }

function render(data){
    var pageurl="http://en.wikipedia.org/?curid=";
    for(var i in data){
      $('#res').append("<div id='resultdiv'><a target='_blank' href='"+pageurl+data[i].pageid+"'><h3>"+data[i].title+"</h3><p>"+data[i].extract+"</p></a></div>");
    }
  }
});