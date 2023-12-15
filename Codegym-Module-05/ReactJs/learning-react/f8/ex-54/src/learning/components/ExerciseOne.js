export default function ExerciseOne() {
    return (
        <>
            <header>
                <div className="logo left">
                    <i id="menu" className="material-icons">menu</i>
                    <img src="https://www.freecodecamp.org/news/content/images/2022/01/yt-logo.png" alt={"pic"}/>
                </div>

                <div className="search center">
                    <form action="">
                        <input type="text" placeholder="Search"/>
                        <button><i className="material-icons">search</i></button>
                    </form>
                    <i className="material-icons mic">mic</i>
                </div>

                <div className="icons right">
                    <i className="material-icons">videocam</i>
                    <i className="material-icons">apps</i>
                    <i className="material-icons">notifications</i>
                    <i className="material-icons display-this">account_circle</i>
                </div>
            </header>

            <div className="nav">
                <a className="nav-link active">
                    <i className="material-icons">home</i>
                    <span>Home</span>
                </a>
            </div>

            <div className="side-bar">
                <div className="nav">
                    <a className="nav-link active">
                        <i className="material-icons">home</i>
                        <span>Home</span>
                    </a>
                    <a className="nav-link">
                        <i className="material-icons">local_fire_department</i>
                        <span>Trending</span>
                    </a>
                    <a className="nav-link">
                        <i className="material-icons">subscriptions</i>
                        <span>Subscriptions</span>
                    </a>
                </div>
                <hr>
                    <a className="nav-link">
                        <i className="material-icons">library_add_check</i>
                        <span>Library</span>
                    </a>
                    <a className="nav-link">
                        <i className="material-icons">history</i>
                        <span>History</span>
                    </a>
                    <a className="nav-link">
                        <i className="material-icons">play_arrow</i>
                        <span>Your Videos</span>
                    </a>
                    <a className="nav-link">
                        <i className="material-icons">watch_later</i>
                        <span>Watch Later</span>
                    </a>
                    <a className="nav-link">
                        <i className="material-icons">thumb_up</i>
                        <span>Liked Videos</span>
                    </a>
                </hr>
            </div>
        </>
    )
}