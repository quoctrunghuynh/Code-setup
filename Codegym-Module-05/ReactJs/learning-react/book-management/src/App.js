import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import BookList from "./components/book/BookList";
import BookDetails from "./components/book/BookDetails"
import BookAdd from "./components/book/BookAdd"
import BookEdit  from "./components/book/BookEdit"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path={'/'} element={<BookList />} />
        <Route path={'/book/:bookId'} element={<BookDetails />} />
        <Route path={'/book/add'} element={<BookAdd />} />
        <Route path={'/book/edit/:bookId'} element={<BookEdit />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
