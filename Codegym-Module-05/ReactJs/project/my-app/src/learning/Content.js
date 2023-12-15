import {useEffect, useState} from "react";

//1.useEffect(callback)
//--- Gọi callback mỗi khi component re-render
//--- Gọi call back sau khi component thêm element vào DOM
//2.useEffect(callback,[])
// ---Chỉ gọi callback 1 lần khi component mount
//3.useEffect(callback,[dependencies])
//------------------------------------------------------------------------
//1.Callback luôn dc gọi khi components mount
const tabs = ['posts', 'comments', 'albums']
export default function Content() {
    const [title, setTitle] = useState('');
    const [posts, setPosts] = useState([]);
    const [type, setType] = useState('posts')

    document.title = title;
    console.log('type change')
    useEffect(() => {
        fetch(`https://jsonplaceholder.typicode.com/${type}`)
            .then(response => response.json())
            .then(posts => setPosts(posts))
    }, [type])

    return (
        <div>
            {tabs.map(tab => (
                <button key={tab}
                        style={type === tab ? {
                            color: '#fff',
                            backgroundColor:'#333'
                        } : {} }
                        onClick={() => setType(tab)}
                >
                    {tab}
                </button>
            ))}
            <h1>Why did you show me???</h1>
            <label htmlFor={"lameText"}>Type something</label>
            <input
                id={"lameText"}
                value={title}
                onChange={e => setTitle(e.target.value)}/>
            <ul>
                {posts.map(post => (
                    <li key={post.id}>{post.title || post.name}</li>
                ))}
            </ul>
        </div>)
}