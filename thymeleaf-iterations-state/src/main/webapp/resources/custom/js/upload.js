document.addEventListener('DOMContentLoaded', () => {
	console.log('content is loaded')
	document.getElementById('uploadBtn').addEventListener('click', () => {
		document.getElementById('uploadInput').click()
	})
	
	document.getElementById('uploadInput').addEventListener('change', () => {
		document.getElementById('uploadForm').submit()
	})
})