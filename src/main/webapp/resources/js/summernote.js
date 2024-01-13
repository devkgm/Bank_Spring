$('#summernote').summernote({
        placeholder: '상세페이지를 작성해주세요.',
        tabsize: 2,
        height: 500,
        backgroundColor:'white',
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ],
        callbacks: {
		    onChange: function(contents, $editable) {
		      $('#content').val($('#summernote').summernote('code'));
		    }
	  }
        
  });