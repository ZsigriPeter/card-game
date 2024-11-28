import './App.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import CardsCollection from "./pages/CardsCollection.tsx";


const router = createBrowserRouter([
            {
                path: "/collection",
                element: <CardsCollection/>,
            },
]);

function App() {
    return (
        <div className={"App"}>
            <RouterProvider router={router}/>
        </div>

    );
}

export default App

