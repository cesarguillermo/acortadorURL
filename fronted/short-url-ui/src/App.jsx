import { useState } from 'react'

import './App.css'

function App() {
  const [url, setUrl] = useState("")
  const [shortUrl, setShortUrl] = useState("")
  const getShortUrl = async () => {
    const response = await fetch("https://acortadorurl-dh3g.onrender.com/api/shorten", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ url: url }),
    })
    const data = await response.json();
    console.log("Respuesta backend:", data);
    setShortUrl(data.shortUrl)


  }

  return (
    <>
      <h1> 🔗 Short URL  </h1>
      <div>
        <input type='text' placeholder="URL"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
        />
        <button onClick={() => getShortUrl()}>Shorten</button>
      </div>
      {shortUrl && (
        <div className='short-url'>
          <p><a href={shortUrl} target='_blank'>{shortUrl}</a></p>
          <button onClick={() => navigator.clipboard.writeText(shortUrl)} > Copy</button>
        </div>
      )}

    </>
  )
}

export default App
